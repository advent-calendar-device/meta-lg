cmake_minimum_required(VERSION 3.16)

project(simple_test_qml VERSION 0.1 LANGUAGES CXX)

set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON) # Buona norma attivarlo per le risorse
set(CMAKE_AUTOUIC ON)
set(CMAKE_CXX_STANDARD 17) # Specifica lo standard (Qt6 preferisce 17 o 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# È meglio includere esplicitamente i moduli base
find_package(Qt6 REQUIRED COMPONENTS Core Gui Quick Qml)

qt_add_executable(appsimple_test_qml
    main.cpp
)

qt_add_qml_module(appsimple_test_qml
    URI simple_test_qml
    VERSION 1.0
    QML_FILES
        Main.qml  # Assicurati che il nome del file sia esattamente Main.qml (case sensitive!)
)

target_link_libraries(appsimple_test_qml
    PRIVATE Qt6::Core Qt6::Gui Qt6::Quick Qt6::Qml
)
