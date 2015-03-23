#include <termios.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <jni.h>
#include<stdlib.h>

JNIEXPORT jobject JNICALL Java_com_sufr_test_open
  (JNIEnv *env, jclass thiz, jstring command)
{
	system(command);
}
