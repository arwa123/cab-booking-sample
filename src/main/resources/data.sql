create table if not exists driver (
	id bigint AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    latitude  decimal(13,2) NOT NULL,
    longitude decimal(13,2)  NOT NULL,
    status VARCHAR(30) NOT NULL 
    
); 



create table if not exists rider (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    latitude  decimal(13,2) NOT NULL,
    longitude decimal(13,2)  NOT NULL
    
); 


create table if not exists ride (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    driver_id  bigint NOT NULL,
    created_at datetime NOT NULL
    
); 