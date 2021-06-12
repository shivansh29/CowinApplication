# CowinApplication

It is **Vaccine Slot Notifier** Application where user gets notified as soon as the slot gets opened up via **Telegram** and **Mail**

**Technology Used** - Spring boot \
**APIs used** - Cowin API, Telegram API, Gmail API

**Working** \
This code runs in every 10 seconds to check availability of slots  \
and if new Centres open up then user is notified via **Telegram** and **Mail**

***Problems faced*** \
![hhhhh](/screenshots/Screenshot%202021-06-05%20185155.png) 

**Solution** \
if you get the above error
It is because you have used 
@Autowired on your telegram class somewhere
and @Component is missing from Telegram Class

![hhhhh](/screenshots/Screenshot%202021-06-05%20191151.png) 

**Solution**

if you get the above error 
Then you have probably used 
ApiContextInitializer.init();
inside main  

this is happening because your Telegram class is getting initialized before ApiConetxt 

and that is happening becuase of @autowire and @component 
So to solve this 
put ApiContextInitializer.init(); 

in static block
