package com.example.di

import com.example.repository.TrainRepository
import com.example.repository.TrainRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<TrainRepository>{
        TrainRepositoryImpl()
    }
}