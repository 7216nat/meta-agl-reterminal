SUMMARY = "The software for Flutter Demo platform of AGL IVI profile"
DESCRIPTION = "A set of packages for AGL Flutter Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-platform-flutter-reterminal \
    "

RDEPENDS:${PN} += "\
    packagegroup-agl-image-ivi \
    packagegroup-agl-profile-graphical-qt5 \
    packagegroup-agl-demo \
    "

AGL_FLUTTER_RUNTIME ?= "runtimeprofile"

AGL_APPS = " \
    flutter-dashboard-${AGL_FLUTTER_RUNTIME} \
    flutter-hvac-${AGL_FLUTTER_RUNTIME} \
    ondemandnavi \
    settings \
    "

RDEPENDS:${PN}:append = " \
    agl-compositor \
    flutter-auto-${AGL_FLUTTER_RUNTIME} \
    flutter-homescreen-reterminal-${AGL_FLUTTER_RUNTIME} \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip mpc' , '', d)} \
    ${AGL_APPS} \
    psplash-portrait-config \
    "