#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "geom_comp.h"
/**
 * Function used in order to get data from easy .txt files
 * with this structure:
 * The first line indicates the number of points of the polygon/set of points
 * The other lines are of type: x y
 * Example: the square with the points (0,0),(1,0),(1,1), (0,1)
 * 4
 * 0 0
 * 1 0
 * 1 1
 * 0 1
 */
point * parsePolygon(char * filename, int * n){
	FILE * fp = fopen(filename, "r");
	char * buffer = malloc(sizeof(char) * 256);
	int line_read = 0;
	fgets(buffer, 256, fp);
	*n = strtol(buffer, NULL, 0);
	point * polygon = malloc(sizeof(point) * (*n));
	int i = 0;
	char * tokenx;
	char * tokeny;
	while(fgets(buffer, 256, fp) != NULL && i < *n){
		line_read++;
		tokenx = strtok(buffer, " ");
		tokeny = strtok(NULL, " ");
		
		if(tokenx != NULL && tokeny != NULL){
			polygon[i].x = strtol(tokenx, NULL, 0);
			polygon[i].y = strtol(tokeny, NULL, 0);
		} else {
			printf("Error in line %d\n", line_read);
		}
		i++;
	}
	fclose(fp);
	return polygon;
}

void print_polygon(point * polygon, int n){
	int i;
	for(i = 0; i < n; i++){
		printf("[%d]%d %d\n", i, polygon[i].x, polygon[i].y);
	}
}


int main(int argc, char * argv[]){
	if(argc < 2){
		printf("Usage: %s <filename> <Q.x> <Q.y>\n", argv[0]);
		return EXIT_FAILURE;
	}
	int n;
	point * polygon = parsePolygon(argv[1], &n);
	point O = {1,1};
	polar_angle_sort(polygon, n, O);
	print_polygon(polygon, n); 
	return EXIT_SUCCESS;
}
