
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <pthread.h>
#define PORT 8080

struct timeval starttime, endtime;

  void *threadfunc(void *parm)
{
	 long int i;
long int LENGTH=1024;


	char buffer[LENGTH];
long int *param = (long int *)parm;
    long int fsize = param[0];
	int sock=param[1];
	         FILE *fp=param[2];
	
	
	
bzero(buffer, LENGTH); 
        int fs_block_sz; 
        
				long int k=(fsize/LENGTH);
				
		for(i=0;i<k;i++)
        {   fs_block_sz = fread(buffer, sizeof(char), LENGTH, fp);
            if(send(sock, buffer, fs_block_sz, 0) < 0)
            {
                fprintf(stderr, "ERROR: Failed to send file \n");
                break;
            }
            bzero(buffer, LENGTH);
        }
	
	
	

}
int main(int argc, char const *argv[])
{
	FILE *fp;
    struct sockaddr_in address;
    int sock = 0,i,j;
	int num;
    struct sockaddr_in serv_addr;
    
    
	pthread_t p[50];
	
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Socket creation error \n");
        return -1;
    }
  
    memset(&serv_addr, '0', sizeof(serv_addr));
  
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);
      
    
    if(inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr)<=0) 
    {
        printf("\nInvalid address/ Address not supported \n");
        return -1;
    }
  
    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        printf("\nConnection Failed \n");
        return -1;
    }
	

	
	fp = fopen ("new.txt", "r");
	fseek(fp, 0L, SEEK_END);
long int size = ftell(fp);

rewind(fp);
 printf("connected to server\n");
	printf("please enter the number of threads you wish to run in between[1,2,4,8] :\n");
	scanf("%d",&num);
	printf("\n");


long int fsize=size/num;

long int *param = (long int *)malloc(1024*1024);
	param[0] = fsize;
	
	param[1]=sock;
	param[2]=fp;
	
gettimeofday(&starttime,NULL);
	double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
	double sec1 = start_time / 1000000.0;	
	
for(j=0;j<num;j++)
{

	pthread_create(&p[j],NULL,threadfunc,param );
	
}

for(j=0;j<num;j++)
{

	pthread_join(p[j],NULL);
	
}

gettimeofday(&endtime,NULL);
double end_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end_time / 1000000.0;
double total_duration=(double)sec2-sec1;

float throughput=(float)((size)/(total_duration*1024*1024));

printf("Throughput of client for uploading file with %d threads is %1f\n",num,throughput);

float latency= (float)(total_duration*1000)/(size);
printf("latency of client for uploading  with %d threads is %1f\n\n",num,latency);



fclose(fp);
	
free(param);
	
    
    return 0;
}

