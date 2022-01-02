# info-redis
Get info from redis and return info 

## 🏁 How To Start
1. Install Java 11: `brew cask install corretto`
2. Set it as your default JVM: `export JAVA_HOME='/Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home'
3. Bring up the Docker environment: Can you start  redis
4. Set data with the next code (with redis-cli):
* HSET model bias -6.21176449
* HSET model deviceExtBrowser=Firefox -0.1131013246
* HSET model bannerExtSize=300x250 -0.6282185905
* HSET model deviceExtType=tablet 0.7294739471
* HSET model deviceLanguage=de -0.1935418172

5. Use Swagger localhost:8080  and post /data  
{
"deviceExtBrowser": "Firefox",
"bannerExtSize": "300x250",
"deviceLanguage": "de",
"deviceExtType": "tablet"
}'
