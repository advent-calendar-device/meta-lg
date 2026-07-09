DESCRIPTION = "Simple Qt6 QML application"
LICENSE = "CLOSED"

SRC_URI = "file://CMakeLists.txt \
           file://main.cpp \
           file://Main.qml"

S = "${WORKDIR}"

inherit qt6-cmake

DEPENDS += "qtbase qtdeclarative qtdeclarative-native"

# opzionale ma utile
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/appsimple_test_qml ${D}${bindir}/
}