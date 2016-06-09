#ifndef __GEOM__COMP__H__
#define __GEOM__COMP__H__
#define _GNU_SOURCE //In order to use qsort_r function
#include "Point.h"
#include <stdlib.h>
#include <stdbool.h>
void polar_angle_sort(point * point_set, int n, point O);
int compare(point p, point q, point O);
int compare_quick_sort(const void * _p, const void * _q, void * _O);
int angle_left(point p0, point p1, point p2);
int turn_left(point p0, point p1, point p2);
int segments_intersect(point p1, point p2, point p3, point p4);



#endif
