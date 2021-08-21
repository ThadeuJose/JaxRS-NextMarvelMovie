# JaxRS-NextMarvelMovie
A pet project to learn about Jax RS

# Commands 	
	mvn clean compile - Compila as classes Java 
	mvn exec:java - Executa 
	mvn test - Testa 

# Test 
	Call api and return the next movie missing the day and other informations 
		days_until	11
		following_production	
			release_date	"2021-11-03"
			title	"Eternals"
		type	"Movie"
		overview	"Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization."
		poster_url	"https://image.tmdb.org/t/p/w500/9f2Q0U3IOsLgrI2HkvldwSABZy5.jpg"
		release_date	"2021-09-01"
		title	"Shang-Chi and the Legend of the Ten Rings"
		
	Call passing the date 
		Post the day plus 1 


# Api I am using 
	https://www.whenisthenextmcufilm.com/
	https://github.com/DiljotSG/MCU-Countdown/blob/develop/docs/API.md
	https://www.whenisthenextmcufilm.com/api
	
# Maven Archetype	
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 -DarchetypeGroupId=org.glassfish.jersey.archetypes -DgroupId=br.com.marvel -DartifactId=jaxrsexample -Dpackage=br.com.marvel