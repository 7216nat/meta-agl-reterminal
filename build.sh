

repo init -b needlefish -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo -m needlefish_14.0.5.xml
repo sync

cd ${{ env.HOME }}/${{ env.TARGET_BRANCH }}/external && git clone -b ${{ env.DISTRO }} https://github.com/7216nat/meta-tensorflow-lite
sed -i "s/usrmerge //" meta-agl/meta-agl-core/conf/distro/poky-agl.conf
mkdir meta-agl/templates/machine/seeed-reterminal/
cp external/meta-agl-reterminal/conf/machine/seeed-reterminal/* meta-agl/templates/machine/seeed-reterminal/

