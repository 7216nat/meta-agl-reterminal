FILESEXTRAPATHS:prepend:seeed-reterminal := "${THISDIR}/${PN}:"

SRC_URI:append:seeed-reterminal = " file://01-agl_vss_overlay_2.2.json \
                                    file://admin.token \"

do_install:append:seeed-reterminal() {
    install -d ${D}${datadir}/kuksa-val/overlays
    install -m 0644 ${WORKDIR}/01-agl_vss_overlay_2.2.json ${D}${datadir}/kuksa-val/overlays/
    install -d ${D}${datadir}/kuksa-val/jwt
    install -m 0644 ${WORKDIR}/admin.token ${D}${datadir}/kuksa-val/jwt/
}