<h2> Data Structures and Structure </h2>

I created three core unit classes: Brand, Model Line, and Model Variant:

<li> A Brand instance stores the brand name and a list of its model lines </li>

<li> A Model Line contains its name and a list of model variants </li>

<li> A Model Variant holds details about the specific variant, including a link to its user manual </li>

This hierarchical structure reflects the website’s navigation flow: the user first selects a brand, then views its model lines, followed by the variants, and finally accesses the user manual.

The data was sourced from real HVAC manufacturers such as Goodman and Carrier. I focused on appliance categories like refrigerators and furnaces, and gathered manuals corresponding to each product variant.

<h2> Setup Instruction </h2>
The application is deployed on Render and can be accessed at <code>https://hvac-dla8.onrender.com</code>.

The backend is built with Java and Spring Boot, using Maven to manage dependencies.
The frontend is built with JavaScript and React, running on Node.js for local testing and offline deployment.

To run the frontend locally, navigate to the project root directory, then:
<code>cd frontend && npm start</code>
This will start the frontend on a local development server.


<h2> Usage and Features </h2>
The application follows a hierarchical structure: Brand → Model Line → Model Variant → User Manual.

Users can utilize the search bar to find both brands and specific model variants. Clicking on a brand navigates to a list of its model lines. Selecting a model variant opens a detailed page displaying specific features such as product voltage and a link to the user manual for that variant.

Each page includes a back button, allowing users to easily return to the previous page (e.g., from Model Variant back to Model Line).

The search bar is case-insensitive and filters results dynamically as the user types. It matches entries based on the starting letters of brands or models, narrowing down the list in real-time to display only relevant products.

<h2> Challenges and Solutions </h2>

One challenge I encountered was linking the frontend and backend due to a CORS (Cross-Origin Resource Sharing) issue, which prevented the frontend from making API requests to the backend. Researching the Spring Boot framework introduced me to the @CrossOrigin annotation, which allows specifying which domains are permitted to access the backend, resolving the CORS problem.

Additionally, since Render did not natively support Java for deployment and Docker was the only viable option to meet my project’s configuration needs, I created a Dockerfile. This Dockerfile builds an intermediate container that compiles the backend source code using Maven, then copies the compiled JAR into a runtime container that runs the application. The final container is deployed on Render to host the backend service.


