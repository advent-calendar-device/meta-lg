SUMMARY = "Advent Calendar App"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/l-giuliani/Advent-Calendar.git;protocol=https;branch=master \
           file://bg.jpg \
           file://0001-no-bgmusic-no-snow.patch \
           file://0001-font-loaded.patch \
           "
SRCREV = "a8348c920c20ee0268d98618163c267264e9861b"

S = "${WORKDIR}/git"

DEST_DIR = "/opt/advent-calendar"

inherit qt6-cmake

DEPENDS += "qtbase qtdeclarative qtdeclarative-native qtmultimedia"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

do_configure:prepend() {
    install -m 0644 ${WORKDIR}/bg.jpg ${S}/images/bg.jpg
}

do_install() {
    install -d ${D}/opt/advent-calendar/bin
    install -m 0755 ${B}/appadventCalendar ${D}${DEST_DIR}/bin/
}

FILES:${PN} += "${DEST_DIR}/bin"