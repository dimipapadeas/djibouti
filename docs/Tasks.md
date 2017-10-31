# OPP-6-WIS-Djibouti

### Tasks
For the PoC we have identified three major components of the architecture:

* The Local Dissemination Environment (LDE)
* The Authoritative WIS Catalogue component (AWISC)
* The Authoritative WIS Catalogue Real-time Notification component (AWISC-RTN)

The PoC has very specific focus and will be largely created as a throw-away prototype. It is important to re-use infrastructure and services and not spend time in manual, complicated, one-off setups that require extra documentation. For this reason, we have opted to use Docker, so that we have access to its vast ecosystem of ready-made containers, providing the majority of the underlying components we will need for the PoC. Considering the PoC will be created in a distributed fashion by different teams of the Association, we also opt for using Docker Compose to allow easily reproducible installations across teams and environments.

#### The Local Dissemination Environment (LDE)

##### Infrastructure
Component | Task description | Core Technologies
--|--|--
Storage | Configuration of the required Storage on the target platform (permissions, space allocation) | Ubuntu/CentOS, shell scripting
Web Server | Installation and configuration of the Web Server component, and its pre-requisites | Apache HTTP Server
FTP Server | Installation and configuration of the FTP Server component, and its pre-requisites | FTPd

##### Implementation
Component | Task description | Core Technologies
--|--|--
Sitemap | Creation of sitemap | XML
Pages | Creation of static HTML content that will describe each dataset, as well as provide searchable metadata  | HTML, JSON-LD
WebApp | Creation of the web-app that will handle data dissemination and CSV visualization | HTML, JavaScript

#### The Authoritative WIS Catalogue component (AWISC)

##### Infrastructure
Component | Task description | Core Technologies
--|--|--
Database | Installation and configuration of the required Database storage on the target platform (user/schema creation) | MySQL, Elasticsearch
Web Server | Installation and configuration of the Web Server component, and its pre-requisites | Java, Maven, Karaf

##### Implementation
Component | Task description | Core Technologies
--|--|--
Sitemap | Creation of sitemap | XML
Web Crawler | Creation of the web-crawler service. This will be responsible to index target sites on a schedule, or on-demand | Java
WebApp | Creation of the web-app that will handle user subscriptions, web-crawler control, notification management | HTML, Java, OSGi, CXF, JavaScript

#### The Authoritative WIS Catalogue Real-time Notification component (AWISC-RTN)

##### Infrastructure
Component | Task description | Core Technologies
--|--|--
Message Queue | Installation and configuration of the Message Queue component, and its pre-requisites | RabbitMQ
