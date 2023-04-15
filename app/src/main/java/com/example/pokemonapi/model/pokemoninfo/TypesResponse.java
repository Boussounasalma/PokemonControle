package com.example.pokemonapi.model.pokemoninfo;

import com.google.gson.annotations.SerializedName;

public class TypesResponse {

    public String nameType;

    public TypesResponse(String nameType) {
        this.nameType = nameType;
    }

    public String getNameType() {
        return nameType;
    }

    @SerializedName("type")//le champ dans json correspond au champ dans la classe
    public Type type;

    public Type getType() {
        return type;
    }

    public static class Type {

        @SerializedName("name")
        public String name;

        public String getName() {
            return name;
        }
    }
}
