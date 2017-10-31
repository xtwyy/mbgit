package com.wyy.mclub.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.*;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 基础属性配置解析
 */
public class BasePropConfig implements Serializable{

        private static final long serialVersionUID = 8042355387234201583L;
        public static HashMap<String,String> propMap = new HashMap<String,String>();
        public static String EMPTY_STR = "";
        private static String configFile = "";
        private static List<String> configFiles = null;

        public BasePropConfig() {
            if(!propMap.isEmpty()){
                parseConfigProperties();
            }
        }

        static{
            //加载默认配置 如有默认配置，需取消以下注释
           // loadConfigFile();
        }

        //加载单配置文件
        private  static boolean loadConfigFile(){
            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources(configFile);
                if(resources == null){
                    return false;
                }

                Properties p = new Properties();
                for(Resource r : resources){
                            if(r != null){
                                p.load(r.getInputStream());
                        mergeProperties(p);
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return true;
        }

        //加载多配置文件
        private  static boolean loadConfigFiles(){
            if(configFiles == null){
                return false;
            }

            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                List<Resource> resources = new ArrayList<Resource>();
                for(int idx = 0; idx<configFiles.size(); idx++){
                    Resource[] tempResoureArr = resolver.getResources(configFiles.get(idx));
                    if(tempResoureArr != null){
                        for(int i = 0; i < tempResoureArr.length; i++){
                            if(tempResoureArr[i] != null){
                                resources.add(tempResoureArr[i]);
                            }
                        }
                    }
                }
                Properties p = new Properties();
                for(Resource r : resources){
                    if(r != null){
                        p.load(r.getInputStream());
                        mergeProperties(p);
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return true;
        }

        //合并配置
        private static void mergeProperties(Properties p){
            Set<Entry<Object, Object>> entrySet= p.entrySet();
            for(Entry<Object, Object> entry : entrySet){
                if(entry.getKey() != null){
                    propMap.put((String)entry.getKey(), (String)entry.getValue());
                }
            }
        }

        /**
         * 获取配置
         * @param key
         * @return value
         */
        public static String get(String key){
            String v = propMap.get(key);
            if(v != null){
                return v.trim();
            }
            return null;
        }

        /**
         * 获取配置
         * @param key
         * @return value
         */
        public static String get(String key,String defaultValue){
            String v = propMap.get(key);
            if(v == null || EMPTY_STR.equals(v.trim())){
                return defaultValue;
            }
            return v.trim();
        }

        /**
         * 获取配置
         * @return HashMap<String,String>
         */
        public static HashMap<String,String> getMap(){
            return propMap;
        }

        //供spring注入配置
        public void setConfigFile(String configFileName) {
            configFile = configFileName;
            if(loadConfigFile()){
                parseConfigProperties();
            }
        }

        //供spring注入配置
        public void setConfigFiles(List<String> configFileNames) {
            configFiles = configFileNames;
            if(loadConfigFiles()){
                parseConfigProperties();
            }
        }

        /**
         * 解析配置,需要你@Override
         * 你可以使用get(key) or get(key,defaultValue) 得到配置
         */
        public void parseConfigProperties(){
        };

}
