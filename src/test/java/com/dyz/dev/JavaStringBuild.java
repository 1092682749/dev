package com.dyz.dev;

public class JavaStringBuild {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append("asd");
        System.out.println(stringBuilder.hashCode());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("xcv");
        System.out.println(stringBuffer.toString().intern().hashCode());

        String s = "xcv";
        System.out.println(s.hashCode());
    }
}
