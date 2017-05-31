# Exception Null
There is a 3.6% unemployment rate and 263,000 unfilled jobs in the tech industry as of 2017. This, 
despite the fact that there were 116,00 tech graduates across colleges in America in 2016. Schools 
do an amazing job of giving us the foundational skills to work in tech but there is a gap between 
the classroom and the office. Our platform aims to bridge the void through challenges that 
emphasize best-practices and real-world interactions. In addition, every paying user will be 
putting money towards goodwill causes for those who may not be able to afford it.

[Website](http://capstone.jonathanpli.com/) | [Video](https://www.youtube.com/watch?v=N6DLzTWoCuY)
| [Poster](https://ischool.uw.edu/sites/default/files/capstone/posters/Poster%20PDF.pdf)

## Overview
Exception Null is a gamified code-learning platform that presents you with interesting and
challenging real-world problems. This is done through a network of peer-reviewers (called gurus)
and learners (called users). Users will opt into a challenge (with a choice of single-player,
group-challenge, and a versus option for both). From here, users with work to solve a real world
problem. Their solutions will be reviewed by gurus that provide detailed feedback and scores.

+ [Landing](http://capstone.jonathanpli.com/)  
  An attention-grabbing, fulfilling experience that invites the user to try our platform.
+ [Dashboard](http://capstone.jonathanpli.com/dashboard)  
  An overview for a registered user that shows them relevant information about their learning or
  reviewing. Here users will be able to monitor their growth or check if they have any pending
  challenges or reviews to complete. Users will also be able to view their history and review their
  previous submissions.
+ [Challenge](http://capstone.jonathanpli.com/challenge)  
  Here a user enters the challenge arena. This area is specially designed to emulate that of an
  integrated development environment (IDE) within the browser. This area shows the user their
  challenge and provides a means of testing and completing it.
+ [Review](http://capstone.jonathanpli.com/evaluate)  
  This section allows peer-reviewers to selectively comment on a user's challenge submission. Given
  industry tools to mark and edit code, peer-reviewers will use their experience to lead users
  onto the right path for their future challenges.
+ [Feedback](http://capstone.jonathanpli.com/feedback)
  Finally, the user will be able to view the feedback they received from a peer reviewer in this
  area. Comments and scoring are shown in logical order and, completing the peer-review toolkit,
  organizes improvement comments so that the user can learn and grow.

## Technologies
As a code learning service, we wanted a platform that was pervasive and useful. It didn't make
sense for a coding platform to be on mobile as one would very rarely (if ever) be developing on
a mobile device. We opted to target the computer (desktop, laptop), and chose a website as a result.
This not only fell into our design and developer teams' strengths, but also provided the most
relevant technology for developers today.

+ [Java](https://www.java.com) (language), [Spring Boot](https://projects.spring.io/spring-boot/) 
(java web server library), [Pebble](http://www.mitchellbosecke.com/pebble/home) 
(spring templating engine)  
  Web stacks are fairly trivial in the sense that, any major server stack will act identical to one
  another. For our case, we chose a stack that we had little to no experience with as, this is
  Capstone, and we wanted to learn! Java being a language our developers were comfortable with, and
  Spring Boot + Pebble a commonly used combination of libraries, we were confident that this backend
  would provide the functionality required to run our service.
+ [Digital Ocean](https://www.digitalocean.com/) (server hardware)  
  One of the most cost-effective, reliable managed hardware providers on the market today. 
+ HTML, [SASS](http://sass-lang.com/) (CSS), Javascript | [jQuery](https://jquery.com/), 
[jQuery Easing](https://github.com/gdsmith/jquery.easing), [HighlightJS](https://highlightjs.org/), 
[ChartJS](http://www.chartjs.org/)  
  As a web platform, you're very much squeezed to use HTML, CSS, and Javascript. SASS helps us
  organize the website's styles, but otherwise provides the same functionality as CSS. The
  Javascript libraries provide animation, animation helpers, code syntax highlighting, and
  dynamic graphical components; respectively.
+ [MariaDB/MySQL](https://mariadb.org/) (database), 
[Connector/J](https://dev.mysql.com/downloads/connector/j/)  
  A tested and tried database backend that allows for transactional guarantees and data replication.
  Also a platform the developers are highly experienced in.
