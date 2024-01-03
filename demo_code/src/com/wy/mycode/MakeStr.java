package com.wy.mycode;



/**
 * @author HelloWorld
 * @date 2023/10/17 12:37
 * @email helloworld.dng@gmail.com
 */
public class MakeStr {

    public static void main(String[] args) {
        String str = "dplyr, tidyr, readr, data.table, stringr, caret, randomForest, xgboost, e1071, glmnet, SparkR, sparklyr, parallel, foreach, doParallel, future, furrr, ggplot2, plotly, lattice, knitr, rmarkdown, h2o, cvTools, quantmod, rvest, text2vec, tidyverse, lubridate, zoo, snow, multicore, shiny, spark.mllib, spark.sql, spark.streaming";
        String tmp = "";
        String format = "'%s'";
        String[] strArray = str.split(",");
        System.out.println(strArray.length);
        for (int i = 0; i < strArray.length; i++) {
            tmp += String.format(format,  strArray[i].trim()) + ",";
        }

        tmp = tmp.substring(0, tmp.length()-1);
        System.out.println(tmp);

        String target = "R -e \"packages=c(WY_FORMAT)\n" +
                "ipak <- function(pkg){\n" +
                "  new.pkg <- pkg[!(pkg %in% installed.packages()[, 'Package'])]\n" +
                "  if (length(new.pkg))\n" +
                "    install.packages(new.pkg, dependencies = TRUE, repos='http://mirrors.aliyun.com/CRAN/')\n" +
                "  sapply(pkg, require, character.only = TRUE)\n" +
                "}\n" +
                "ipak(packages)\"";

        System.out.println(target.replace("WY_FORMAT", tmp));


    }
}
