#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<sys/time.h>
#include<string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <malloc.h>


char *data1,*data2;
struct timeval starttime, endtime;




void *read_write_function(void *parm)
{
int i;	
	long int *param = (long int *)parm;
    long int fsize = param[0];
	int size=param[1];
	int count=param[2];
	
	//printf("%d\t,%d\t,%d\n",fsize,size,count);

for( i=0;i<fsize/size;i++)
{
memcpy(&data1[fsize*count]+(size*i),&data2[fsize*count]+(size*i),size);
}


}

void *sequential_write_function(void *parm)	
{

int i;	
	long int *param = (long int *)parm;
    long int fsize = param[0];
	int size=param[1];
	int count=param[2];
	
for(i=0;i<fsize/size;i++)
{

memset(&data2[fsize*count]+(size*i),'g',size);
}
}

void *random_write_function(void *parm)	
{

int i;	
	long int *param = (long int *)parm;
    long int fsize = param[0];
	int size=param[1];
	int count=param[2];
	long int newsize=fsize/size;
	
for(i=0;i<newsize;i++)
{
long int 
long rand=random()%(newsize-1);
memset(&data2[fsize*count]+(size*rand),'g',size);
}
}




void main()
{
pthread_t threads[15];
int bsize,size;
int k,p;
printf("Memory benchmarking\n");
printf("Select the block size : Enter 1 for 8B,2 for 8KB, 3  for 8MB, 4 for 80MB\n");

scanf("%d",&bsize);
printf("\n"); 
if(bsize==1)
{
size=(int)8;
}
else if (bsize==2)
{
	size=(int)8*1024;
}
else if(bsize==3)
{
	size=(int)8*1048576;
}

else if(bsize==4)
{
	size=(long int) 8*10485760;
}
else {
printf("invalid option try again\n");
exit(0);
}

printf("sequential read+write memory access using different number of threads and their latency and throughput\n");

printf("memory function for size %d\n",size);
for(k=1;k<10;k=k*2)
{   
	data1=malloc(1024*1024*1100);
	data2=malloc(1024*1024*1100);
	memset(data2,'g',1024*1024*1100);

	long int filesize=(1024*1024*1100)/k;
	
	gettimeofday(&starttime,NULL);
	double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
	double sec1 = start_time / 1000000.0;
	int count=0;
	long int *param = (long int *)malloc(1024*1024*1100);
	param[0] = filesize;
	param[1] = size;

	for(p=0;p<k;p++)
	{
		param[2]=count;
		
		count=count+1;		
		pthread_create(	&threads[p],NULL,read_write_function,param);
sleep(0);	    
	}
	
	for(p=0;p<k;p++)
	{
    pthread_join(threads[p],NULL);
	
	}
	count=0;
gettimeofday(&endtime,NULL);
double end_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end_time / 1000000.0;
double total_duration=(double)sec2-sec1;	

float throughput=(float)((1024*1024*1100)/(total_duration*1024*1024));


printf("Throughput of memory with %d threads is %1f\n",k,throughput);


if(size==8)
{
float latency= (float)(total_duration*1000)/(1024*1024*1100);
printf("latency of memory with %d threads is %1f\n\n",k,latency);
}


free(data1);
free(data2);
free(param);

}
printf("\n\n");

printf("sequential write memory access using different number of threads and their latency and throughput\n");
printf("\n\n");    

printf("memory function for size %d\n",size);
for(k=1;k<10;k=k*2)
{
	
	data2=malloc(1024*1024*1100);
long int filesize=(1024*1024*1100)/k;
	
	gettimeofday(&starttime,NULL);
double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
double sec1 = start_time / 1000000.0;
int count=0;
	long int *param = (long int *)malloc(1024*1024*1100);
	param[0] = filesize;
	param[1] = size;

	for(p=0;p<k;p++)
	{
		param[2]=count;
		count = count+1;
	pthread_create(	&threads[p],NULL,sequential_write_function,param);
	sleep(0);
	}
	
	for(p=0;p<k;p++)
	{
    pthread_join(threads[p],NULL);
	
	}
gettimeofday(&endtime,NULL);
double end1_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end1_time / 1000000.0;
double total_duration=(double)sec2-sec1;	

float throughput=(float)((1024*1024*1100)/(total_duration*1024*1024));


printf("Throughput of memory with %d threads is %1f\n",k,throughput);


if(size==8)
{
float latency= (float)(total_duration*1000)/(1024*1024*1100);
printf("latency of memory with %d threads is %1f\n\n",k,latency);
}


free(data2);

}
printf("\n\n");

printf("random write memory access using different number of threads and their latency and throughput\n");
printf("\n\n");    

printf("memory function for size %d\n",size);
for(k=1;k<10;k=k*2)
{
	
	data2=malloc(1024*1024*1100);
long int filesize=(1024*1024*1100)/k;
	
	gettimeofday(&starttime,NULL);
double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
double sec1 = start_time / 1000000.0;
int count=0;
	long int *param = (long int *)malloc(1024*1024*1100 );
	param[0] = filesize;
	param[1] = size;

	for(p=0;p<k;p++)
	{
		param[2]=count;
		count = count+1;
	pthread_create(	&threads[p],NULL,random_write_function,param);
	sleep(0);
	}
	
	for(p=0;p<k;p++)
	{
    pthread_join(threads[p],NULL);
	
	}
gettimeofday(&endtime,NULL);
double end1_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end1_time / 1000000.0;
double total_duration=(double)sec2-sec1;	

float throughput=(float)((1024*1024*1100)/(total_duration*1024*1024));


printf("Throughput of memory with %d threads is %1f\n",k,throughput);


if(size==8)
{
float latency= (float)(total_duration*1000)/(1024*1024*1100);
printf("latency of memory with %d threads is %1f\n\n",k,latency);
}


free(data2);

}
printf("\n\n");

}



