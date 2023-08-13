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

AGL_FLUTTER_RUNTIME ?= "runtimeprofile"

# cluster
IMAGE_FEATURES += "splash package-management ssh-server-openssh"

IMAGE_KUKSA_PACKAGES = " \
    kuksa-val \
    kuksa-val-agl \
    kuksa-dbc-feeder \
    kuksa-vss-init \
	kuksa-viss-client \
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
CLUSTER_PACKAGES= " \
	flutter-cluster-dashboard-reterminal-${AGL_FLUTTER_RUNTIME}\
	"
# generic
IMAGE_INSTALL:append = " \
    ${IMAGE_KUKSA_PACKAGES}  \
    ${SEEED_RETERMINAL_INSTALLLS} \
    ${CLUSTER_PACKAGES} \ 
    simple-can-simulator \
    "

IMAGE_INSTALL:append = " \
	gstreamer1.0 \
	libcamera \
	x264 \
	gstreamer1.0-plugins-ugly \
	camera-gstreamer \
	python3-tensorflow-lite-example \
	tflite-examples-init \
	libedgetpu-max \
	libgfortran \
	"
# end cluster
