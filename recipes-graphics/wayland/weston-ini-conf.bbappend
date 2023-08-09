FILESEXTRAPATHS:prepend:seeed-reterminal := "${THISDIR}/${PN}:"

SRC_URI:append:seeed-reterminal = " file://dsi.cfg \
                                    file://alternative_HDMI_output.cfg "

do_compile:append:seeed-reterminal() {
    if grep -q '\[output\]' ${WORKDIR}/${F}.cfg; then
        sed -i 's/^activation-area=.*/activation-area=720x960+0,160/' ${WORKDIR}/weston.ini.flutter
    fi

    cat ${WORKDIR}/alternative_HDMI_output.cfg >> ${WORKDIR}/weston.ini.flutter
}