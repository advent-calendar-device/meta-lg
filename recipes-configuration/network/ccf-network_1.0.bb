SUMMARY = "Systemd-Networkd configuration"
LICENSE = "CLOSED"

SRC_URI = "file://10-eth0.network"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-eth0.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} += "${sysconfdir}/systemd/network"