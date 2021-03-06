package com.apress.prospring5.ch4.custom;

import com.apress.prospring5.ch4.FullName;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");
        setValue(new FullName(name[0],name[1]));

    }


    @Override
    public String getAsText() {
        FullName fullName=(FullName)getValue();
        return fullName.getFirstName()+": " +fullName.getLastName();
    }
}
