#include "geom_comp.h"
/*
 * Return 1 q > p
 * Return 0 p = q (in order to render quicksort stable)
 * Return -1 q < p
 */
int compare(point p, point q, point O){
	int d = angle_left(p, q, O);
	if(d > 0)
		return -1;
	else if(d < 0)
		return 1;
	else { // p, q, O lie on the same line
		//Stanno dalla stessa parte	--> Controllo le lunghezze
		if(((p.x - O.x) * (q.x - O.x) >= 0) && ((p.y - O.y) * (q.y - O.y) >= 0)){
			int Lp = p.x * p.x + p.y * p.y;
			int Lq = q.x * q.x + q.y * q.y;
			if (Lq > Lp){
				return -1;
			}
			else if(Lq == Lp){
				return 0;
			}
			else{ //Lq < Lp
				return 1;
			}
		} else { // Non stanno dalla stessa parte
			if(p.y <= O.y && p.x <= O.x)
				return 1;
			else
				return -1;
		}
	}
}

int compare_quick_sort(const void * _p, const void * _q, void * _O){
	point p = *(point *) _p;
	point q = *(point *) _q;
	point O = *(point *) _O;
	return compare(p, q, O);
}

void polar_angle_sort(point * point_set, int n, point O){
	qsort_r(point_set, n, sizeof(point), compare_quick_sort, &O); 
}



int angle_left(point p0, point p1, point p2){
	int d = (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
	return d;
}

int turn_left(point p0, point p1, point p2){
	return angle_left(p0, p1, p2);
}

int segments_intersect(point p1, point p2, point p3, point p4){
	int d1 = angle_left(p3, p4, p1);
	int d2 = angle_left(p3, p4, p2);
	int d3 = angle_left(p1, p2, p3);
	int d4 = angle_left(p1, p2, p4);
	if(d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0){
		bool a = (p2.x - p3.x) * (p1.x - p3.x) <= 0 &&  (p2.y - p3.y) * (p1.y - p3.y) <= 0;
		bool b = (p2.x - p4.x) * (p1.x - p4.x) <= 0 &&  (p2.y - p4.y) * (p1.y - p4.y) <= 0;
		bool c = (p4.x - p1.x) * (p3.x - p1.x) <= 0 &&  (p4.y - p1.y) * (p3.y - p1.y) <= 0;
		return a || b || c;
	} else {
		bool a = (d1 <= 0 && d2 >= 0) || (d1 >= 0 && d2 <= 0);
		bool b = (d3 <= 0 && d4 >= 0) || (d3 >= 0 && d4 <= 0);
		return a && b;
	}
	return false;
}
