# OPP-6-WIS-Djibouti
For a background regarding OPP-6, please read the relevant [discussion on OPP-6](https://github.com/OpenWIS/openwis-documentation/issues/309).

This repository contains documentation as well as different Proof of Concept implementations for OPP6.

## High-level flow diagram
Presents a bird's eye view of the operations and basic data-flows envisaged for OPP-6. The main actors and actions are 
identified as well as the main building blocks of the system. We are using draw.io to maintain the [high-level flow diagram](https://www.draw.io/#HNMichas%2FOPP-6-WIS-Djibouti%2Fmaster%2Fdocs%2FOPP6-Flow-diagram.xml).

An exported version of the diagram in PNG is available next (note, this is manually exported, so it may not reflect the latest version of the diagram):
![](docs/img/OPP6-Flow-diagram.png)

## PoC architectural specs

### Point 0 - General

1. Q: Implementing security restrictions/checks will not be a target for the PoC. However, should we support some very basic user authentication? Regarding the calls in (P5) and (P6) we could have some basic, token-based authentication in place especially since (P14) will be deployed on public Internet.  
A: 

2. Q: Do we want commercial search engines to also crawl AWC?  
A:


### Point 1 - Creation of CSVs

1. Q: Should the local WebApp (P11) provide a functionality to creates CSVs online?  
A:

2. Q: Do we care for the format/columns of the CSVs? Is there a standard to be used?  
A:

3. Q: We will need some sample CSVs, who is going to prepare/provide them?  
A:


### Point 2 - Pushing CSVs to the Web Server

1. Q: Do we intend to provide some tool here or is it up to the user?  
A:


### Point 3 - Pushing CSVs to a secondary dissemination channel

1. Q: Do we intend to provide some tool here or is it up to the user?  
A:


### Point 4 - Registering sitemap with a commercial search engine

1. Q: Which search engine will we pick for the PoC?  
A:

2. Q: We need some info/research here regarding the format/content of the sitemap.  
A:

3. Q: We need some info/research here regarding the registration process, time to crawl, frequency of updates etc.  
A:


### Point 5 - Registering sitemap with the AWC

1. Q: Can we use the exact same sitemap as in (P3)? This is largely related to the specs of (P14).  
A:


### Point 6 - Notifying AWC of data updates

1. Q: Do we envisage anything more complicated than an HTTP/GET call?  
A:

2. Q: Alternatively, do we need this call or we rely on the Crawler identifying new data (and proceeding to sending notifications)?  
A:

### Point 7 - Local web server

1. Q: For the PoC we need to define the Web Server to be used/supported.  
A:


### Point 8 - Local secondary dissemination channel

1. Q: Is the secondary dissemination channel something we consider for the PoC? If it is, we need to define what that should be.  
A:

### Point 9 - Generating the sitemap

1. Q: How is the sitemap going to be generated? If not manually, we should investigate tools/methods.  
A:

### Point 10 - Generating web pages for CSVs

1. Q: How are the pages going to be generated? If not manually, we should investigate tools/methods.  
A:

### Point 11 - The local WebApp

1. Q: What should be the main functionality of the local WebApp?  
A:

### Point 12 - Optimising search queries to the commercial search engine

1. Q: Once we choose the search engine to use, we need to investigate how to query it according to our needs. Can you provide a few representative queries we would like to run?
A:

### Point 13 - AWC crawling local dissemination environments

1. Q: Decide on the crawling mechanism as well as the underlying storage mechanism (this is directly related to the queries to be supported by (P14)).  
A:

### Point 14 - The AWC WebApp

1. Q: Provide a few indicative queries.  
A:

### Point 15 - AWC real-time notifications

1. Q: Is the central approach for real-time notifications the one we want for the PoC?  
A:
