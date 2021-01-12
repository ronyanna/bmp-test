package com.bmp.service;

import com.itextpdf.layout.property.TextAlignment;


public class ReportField implements Comparable<ReportField> {
    public static final int LEFT=1;
    public static final int RIGHT=2;
    public static final int TOP=4;
    public static final int BOTTOM=8;
    public static final int ALL=LEFT+RIGHT+TOP+BOTTOM;

    private TextAlignment alignment;

    private  ReportFieldType fieldType=ReportFieldType.LABEL;

    private int index;

    private int colSpan=1;

    private int rowSpan=1;

    private String backgroundColor;

    private int border=ALL;

    private boolean bold;

    private String []fields;

    public int getColSpan() {
        return colSpan;
    }

    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public TextAlignment getAlignment() {
        return alignment;
    }

    public void setAlignment(TextAlignment alignment) {
        this.alignment = alignment;
    }

    public ReportField(ReportFieldType fieldType, int colSpan, int rowSpan, String backgroundColor, int border, String...fields) {
        this.fieldType=fieldType;
        this.colSpan = colSpan;
        this.rowSpan = rowSpan;
        this.backgroundColor = backgroundColor;
        this.fields = fields;
        this.border=border;
    }


    public ReportField(ReportFieldType fieldType, int colSpan, int rowSpan, String backgroundColor, String...fields) {
        this.fieldType=fieldType;
        this.colSpan = colSpan;
        this.rowSpan = rowSpan;
        this.backgroundColor = backgroundColor;
        this.fields = fields;
    }

    public ReportField(int colSpan, String...fields) {
        this.colSpan = colSpan;
        this.fields = fields;
        this.alignment=alignment;
        this.border=border;
    }

    public ReportField(int colSpan, TextAlignment alignment, int border, String...fields) {
        this.colSpan = colSpan;
        this.fields = fields;
        this.alignment=alignment;
        this.border=border;
    }


    public ReportField(ReportFieldType fieldType, int colSpan, String backgroundColor, String...fields) {
        this.fieldType=fieldType;
        this.colSpan = colSpan;
        this.backgroundColor = backgroundColor;
        this.fields = fields;
    }


    public ReportField(int index, ReportFieldType fieldType, int colSpan, int rowSpan, String backgroundColor, String...fields) {
        this.index=index;
        this.fieldType=fieldType;
        this.colSpan = colSpan;
        this.rowSpan = rowSpan;
        this.backgroundColor = backgroundColor;
        this.fields = fields;
    }

    public ReportField(int index, ReportFieldType fieldType, int colSpan, String backgroundColor, String...fields) {
        this.index=index;
        this.fieldType=fieldType;
        this.colSpan = colSpan;
        this.backgroundColor = backgroundColor;
        this.fields = fields;
    }

    public ReportField() {
    }

    public String[] getFields() {
        return fields;
    }

    @Override
    public int compareTo(com.bmp.service.ReportField other) {
        return this.index-other.index;
    }

    public ReportFieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(ReportFieldType fieldType) {
        this.fieldType = fieldType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }
}
