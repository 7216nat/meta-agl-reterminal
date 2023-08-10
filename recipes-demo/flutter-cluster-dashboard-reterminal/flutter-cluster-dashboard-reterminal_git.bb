SUMMARY = "Flutter Instrument Cluster "
DESCRIPTION = "An instrument cluster app written in dart for the flutter runtime"
AUTHOR = "Aakash Solanki, Xukai Chen"
HOMEPAGE = "https://github.com/7216nat/flutter_instrument_cluster"

SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0c52b0e4b5f0dbf57ea7d44bebb2e29d"

SRC_URI = "git://github.com/7216nat/flutter_instrument_cluster;protocol=https;branch=master \
    file://flutter-cluster-dashboard.service \
    file://flutter-cluster-dashboard.yaml \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit agl-app flutter-app 

PUBSPEC_APPNAME = "flutter_cluster_dashboard"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"
OPENROUTE_API_KEY ??= "YOU_NEED_TO_SET_IT_IN_LOCAL_CONF"
CLUSTER_DEMO_VISS_HOSTNAME ??= "192.168.10.2"

AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_ID = "flutter_cluster_dashboard"
AGL_APP_NAME = "Cluster"

do_install:append() {
    # install -D -m 0644 ${WORKDIR}/flutter-cluster-dashboard.service ${D}${systemd_user_unitdir}/flutter-cluster-dashboard.service
    # install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    # ln -s ../flutter-homescreen.service ${D}${systemd_user_unitdir}/agl-session.target.wants/flutter-cluster-dashboard.service
 
    install -d ${D}${sysconfdir}/xdg/AGL
    install -m 0644 ${WORKDIR}/flutter-cluster-dashboard.yaml \
        ${D}${sysconfdir}/xdg/AGL/flutter-cluster-dashboard.yaml.default

    install -m 0644 ${WORKDIR}/flutter-cluster-dashboard.yaml \
        ${D}${sysconfdir}/xdg/AGL/flutter-cluster-dashboard.yaml

    install -m 0755 -d ${D}${sysconfdir}/default/ 
    echo 'OPENROUTE_API_KEY:${OPENROUTE_API_KEY}' >> ${D}${sysconfdir}/default/openroutekey
}

FILES:${PN} += "${sysconfdir}/default/ ${sysconfdir}/xdg/AGL"
