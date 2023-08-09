require recipes-platform/images/agl-image-ivi.bb

DESCRIPTION = "AGL Flutter based Demo Platform image"
LICENSE = "MIT"

require recipes-platform/images/agl-demo-features.inc

# add packages for demo platform (include demo apps) here
IMAGE_INSTALL:append = " \
    packagegroup-agl-demo-platform-flutter-reterminal \
    weston-ini-conf-flutter \
    ${@bb.utils.contains("AGL_FEATURES", "agl-demo-preload", "", "weston-terminal-conf", d)} \
"
SPLASH = "psplash-raspberrypi"

# cluster
IMAGE_FEATURES += "splash package-management ssh-server-openssh"

IMAGE_KUKSA_PACKAGES = " \
    kuksa-val \
    kuksa-val-agl \
    kuksa-dbc-feeder \
    kuksa-vss-init \
"
SEEED_RETERMINAL_INSTALLLS= " \
	kernel-modules \
	seeed-linux-dtoverlays \
	ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-sans-condensed \
	ttf-dejavu-serif ttf-dejavu-serif-condensed ttf-dejavu-common \
	python3-pyqt5 \
	python3-logging \
	python3-psutil \
	python3-evdev \
	evtest \
	iperf3 \
	i2c-tools \
	util-linux \
	e2fsprogs-resize2fs \
	parted \
	glibc \
	v4l2-test-git \
	spidev-test \
	python3-seeed-python-reterminal \
	"

# generic
IMAGE_INSTALL:append = " \
    ${@bb.utils.contains("AGL_FEATURES", "agl-demo-preload", "", "${IMAGE_KUKSA_PACKAGES}", d)} \
    ${SEEED_RETERMINAL_INSTALLLS} \
	simple-can-simulator \
    "
IMAGE_INSTALL:append = " \
	gstreamer1.0 \
	libcamera \
	x264 \
	gstreamer1.0-plugins-ugly \
	camera-gstreamer \
	python3-tensorflow-lite-example \
	libedgetpu-max \
	libgfortran \
	"
# end cluster