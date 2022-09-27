package com.hexiaofei.nacoscustomer.utils;

import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.*;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hexiaofei
 * @date 2022-05-08 22:15
 * @since
 */
@Slf4j
public class IP2RegionUtils {

    public static String BTREE_SEARCH = "b-tree";
    public static String BINARY_SEARCH = "binary";
    public static String MEMORY_SEARCH = "memory";

    static{

    }

    public static void getRegion(String searchType){
        String dbPath = Ip2regionUtil.class.getResource("/ip2region/ip2region.db").getPath();
        File file = new File(dbPath);
        if ( file.exists() == false ) {
            log.info("Error: Invalid ip2region.db file");
            return;
        }

        int algorithm = DbSearcher.BTREE_ALGORITHM;
        String algoName = "B-tree";
        if (StringUtils.isEmpty(searchType)) {
            if ( searchType.equalsIgnoreCase("binary")) {
                algoName  = "Binary";
                algorithm = DbSearcher.BINARY_ALGORITHM;
            } else if ( searchType.equalsIgnoreCase("memory") ) {
                algoName  = "Memory";
                algorithm = DbSearcher.MEMORY_ALGORITYM;
            }
        }

        try {
            log.info("initializing "+algoName+" ... ");
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //define the method
            Method method = null;
            switch ( algorithm )
            {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }

            double sTime = 0, cTime = 0;
            String line = null;
            DataBlock dataBlock = null;
            while ( true ) {
                log.info("ip2region>> ");
                line = reader.readLine().trim();
                if ( line.length() < 2 ) continue;
                if ( line.equalsIgnoreCase("quit") ) break;
                if ( Util.isIpAddress(line) == false ) {
                    log.info("Error: Invalid ip address");
                    continue;
                }

                sTime = System.nanoTime();
                dataBlock = (DataBlock) method.invoke(searcher, line);
                cTime = (System.nanoTime() - sTime) / 1000000;
                System.out.printf("%s in %.5f millseconds\n", dataBlock, cTime);
            }

            reader.close();
            searcher.close();
            log.info("+--Bye");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
