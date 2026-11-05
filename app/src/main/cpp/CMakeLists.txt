cmake_minimum_required(VERSION 3.22.1)
project(luaulab)

add_library(luaulab SHARED NativeBridge.cpp)

find_library(log-lib log)

target_link_libraries(luaulab ${log-lib})
