package com.ivojesus.adapters.googleapi.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VolumeInfo {
    public String title;
    public String[] authors;
    public String publisher;
    public String[] categories;
    public Identifier[] industryIdentifiers;
}
