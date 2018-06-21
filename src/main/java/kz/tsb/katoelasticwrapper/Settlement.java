package kz.tsb.katoelasticwrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement {

    private boolean IsMarkedToDelete;

    private String Parent;

    private String NameKaz;

    private Integer AreaType;

    private Integer Level;

    private Integer Id;

    private String NameRus;

    private Integer Code;

    public Settlement() {
    }

    @JsonProperty("IsMarkedToDelete")
    public boolean isMarkedToDelete() {
        return IsMarkedToDelete;
    }

    @JsonProperty("IsMarkedToDelete")
    public void setMarkedToDelete(boolean markedToDelete) {
        IsMarkedToDelete = markedToDelete;
    }

    @JsonProperty("Parent")
    public String getParent() {
        return Parent;
    }

    @JsonProperty("Parent")
    public void setParent(String parent) {
        Parent = parent;
    }

    @JsonProperty("NameKaz")
    public String getNameKaz() {
        return NameKaz;
    }

    @JsonProperty("NameKaz")
    public void setNameKaz(String nameKaz) {
        NameKaz = nameKaz;
    }

    @JsonProperty("AreaType")
    public Integer getAreaType() {
        return AreaType;
    }

    @JsonProperty("AreaType")
    public void setAreaType(Integer areaType) {
        AreaType = areaType;
    }

    @JsonProperty("Level")
    public Integer getLevel() {
        return Level;
    }

    @JsonProperty("Level")
    public void setLevel(Integer level) {
        Level = level;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return Id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        Id = id;
    }

    @JsonProperty("NameRus")
    public String getNameRus() {
        return NameRus;
    }

    @JsonProperty("NameRus")
    public void setNameRus(String nameRus) {
        NameRus = nameRus;
    }

    @JsonProperty("Code")
    public Integer getCode() {
        return Code;
    }

    @JsonProperty("Code")
    public void setCode(Integer code) {
        Code = code;
    }
}
