SUMMARY = "Advent Calendar Image."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "ssh-server-dropbear"

PACKAGECONFIG:remove:pn-systemd = " unmanaged-network"
PACKAGECONFIG:append:pn-systemd = " networkd resolved"

IMAGE_INSTALL:remove = "init-ifupdown"

IMAGE_ROOTFS_SIZE ?= "8192"
#IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 1048576"

IMAGE_INSTALL:append = " \
                    qtbase \
                    qtbase-plugins \
                    qtdeclarative \
                    qtmultimedia \
                    qtmultimedia-qmlplugins"

IMAGE_INSTALL:append = " gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"

IMAGE_INSTALL:append = " alsa-utils"

IMAGE_INSTALL:append = " advent-calendar-app advent-calendar-data ccf-network"

