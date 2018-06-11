
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#define PORT 8080


int main(int argc, char const *argv[])
{
    int server_fd, new_socket, valread;
    struct sockaddr_in address;
    int opt = 1;
    int addrlen = sizeof(address);
    int LENGTH=1024;
	char buffer[LENGTH];
	
    
    FILE *fp;    
	
    
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
    {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }
      
    
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons( PORT );
      
    printf("waiting for connection\n");
    if (bind(server_fd, (struct sockaddr *)&address,sizeof(address))<0)
    {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }
    if (listen(server_fd, 3) < 0)
    {
        perror("listen");
        exit(EXIT_FAILURE);
    }
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, 
                       (socklen_t*)&addrlen))<0)
    {
        perror("accept");
        exit(EXIT_FAILURE);
    }
	
	printf("connection successfull\n");
    
	
	
	fp=fopen("downloadedfile.txt","a");
	
	 bzero(buffer, LENGTH); 
            int fr_block_sz = 0;
			
			
            while((fr_block_sz = recv(new_socket, buffer, LENGTH, 0)) > 0) 
            {
                int write_sz = fwrite(buffer, sizeof(char), fr_block_sz, fp);
                if(write_sz < fr_block_sz)
                {
                    error("File write failed on server.\n");
                }
                bzero(buffer, LENGTH);
                if (fr_block_sz == 0 || fr_block_sz != 1024) 
                {
                    break;
                }
            }
			
			

            
    fclose(fp);
	
    return 0;
}