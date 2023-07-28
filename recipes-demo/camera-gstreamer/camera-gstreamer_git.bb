SUMMARY     = "Camera gstreamer demo application"
DESCRIPTION = "AGL demonstration of displaying incoming camera feed"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/camera-gstreamer"
SECTION     = "apps"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = " \
    wayland wayland-native \
    gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad \
"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/7216nat/camera-gstreamer-custom;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "d4c4a32d81d21870bf9ff8e9f9a1049324cbf028"

S  = "${WORKDIR}/git"

inherit cmake pkgconfig

RDEPENDS:${PN} += " \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"