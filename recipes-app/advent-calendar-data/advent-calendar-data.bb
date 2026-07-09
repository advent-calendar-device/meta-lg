SUMMARY = "Advent Calendar App Data Files"
LICENSE = "CLOSED"

SRC_URI = "file://data \
            file://fonts/OpenSans-Regular.ttf"

SRC_URI:append:mx8 = " file://app-environment.sh \
                                    file://kms.json"

S = "${WORKDIR}"


DEST_DIR = "/opt/advent-calendar"

do_install() {
    install -d ${D}${DEST_DIR}/data
    install -d ${D}${libdir}/fonts

    cp -r --no-preserve=ownership,mode ${S}/data/. ${D}${DEST_DIR}/data/
    #chown -R root:root ${D}${DEST_DIR}/data

    install -m 0644 ${S}/fonts/OpenSans-Regular.ttf ${D}${libdir}/fonts/
}

do_install:append:mx8() {
    install -d ${D}${DEST_DIR}/env
    install -m 0755 ${S}/app-environment.sh ${D}${DEST_DIR}/env/
    install -m 0644 ${S}/kms.json ${D}${DEST_DIR}/env/
}

FILES:${PN} += "${DEST_DIR}/* \
                ${libdir}/fonts"