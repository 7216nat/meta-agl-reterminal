#!/bin/bash 
HOME=`pwd`
TARGET_BRANCH=needlefish
HOME=$HOME/$TARGET_BRANCH
DISTRO=kirkstone
MACHINE=seeed-reterminal

repo init -b needlefish -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo -m needlefish_14.0.5.xml
repo sync

cd $HOME/external && git clone -b $DISTRO https://github.com/7216nat/meta-tensorflow-lite.git
cd $HOME/external && git clone https://github.com/7216nat/meta-agl-reterminal.git
cd $HOME/bsp && git clone https://github.com/Seeed-Studio/meta-seeed-reterminal.git

sed -i "s/usrmerge //" $HOME/meta-agl/meta-agl-core/conf/distro/poky-agl.conf
cp -r $HOME/external/meta-agl-reterminal/conf/machine/seeed-reterminal/ $HOME/meta-agl/templates/machine/

source meta-agl/scripts/aglsetup.sh -b seeed-reterminal -m seeed-reterminal agl-demo agl-devel agl-flutter

bitbake-layers add-layer $HOME/external/meta-tensorflow-lite
bitbake-layers add-layer $HOME/bsp/meta-raspberrypi
bitbake-layers add-layer $HOME/extenal/meta-agl-reterminal

cat $HOME/extenal/meta-agl-reterminal/local.conf >> $HOME/$MACHINE/conf/local.conf
