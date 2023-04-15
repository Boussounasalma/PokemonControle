package com.example.pokemonapi.di;

import android.app.Application;

import androidx.room.Room;

import com.example.pokemonapi.database.AppDatabase;
import com.example.pokemonapi.database.PokemonInfoDAO;
import com.example.pokemonapi.database.PokemonListDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
//fournit l'application android en cour d'execution
    private final Application application;

    public DatabaseModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton //instance doivent etre cree au tant qu'instance unique
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    //fournit une instance de la base de donné
    AppDatabase provideAppDatabase(Application application) {
        //specification de la classe et les configuration
        return Room.databaseBuilder(application, AppDatabase.class, "PokemonDatabase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries() //autoriser l'exécution de requetes sur le thread principal
                .build();
    }

    @Provides
    @Singleton
    //fourni une instance dao
    PokemonListDAO providePokemonListDAO(AppDatabase appDatabase) {
        return appDatabase.pokemonListDAO();
    }

    @Provides
    @Singleton
    //acceder aux donnée des informations détaillés
    PokemonInfoDAO providePokemonInfoDAO(AppDatabase appDatabase) {
        return appDatabase.pokemonInfoDAO();
    }
}
