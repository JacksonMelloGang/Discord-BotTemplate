package fr.askyna.bot.commands;

import javax.annotation.Nullable;

public enum Category {
    GENERAL("General", 0),
    FUN("Fun", 1),
    MODERATION("Moderation", 2),
    UTILITIES("Utilities", 3),
    MUSIC("Music", 4),
    NSFW("NSFW", 5),
    ADMINISTRATION("Administration", 6),
    OTHER("Other", 7);

    String name;
    int id;

    Category(String name) {
        this.name = name;
    }

    Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Category{name='%s' , id='%s'}", name, id);
    }

    @Nullable
    public String getNameById(int id){
        for(Category c : Category.values()){
            if(c.id == id){
                return c.name;
            }
        }
        return null;
    }



}
