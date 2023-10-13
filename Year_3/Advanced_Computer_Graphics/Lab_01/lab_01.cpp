// Include standard headers
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <GLFW/glfw3.h>

/* Run Command:
g++ -std=c++23 -o firstLabGlfw firstLabGlfw.cpp -lGL -lGLU -lX11 -lXxf86vm -lXrandr -lpthread -lXi -lglfw
*/
//variables
GLFWwindow* window;
const int width = 1024, height = 768;

int main()
{
	// Initialise GLFW
	if (!glfwInit())
	{
		fprintf(stderr, "Failed to initialize GLFW\n");
		return -1;
	}

	// Open a window and create its OpenGL context
	window = glfwCreateWindow(width, height, "Our first test :)", NULL, NULL);
	if (window == NULL) {
		fprintf(stderr, "Failed to open GLFW window.");
		glfwTerminate();
		return -1;
	}

	glfwMakeContextCurrent(window);

	//specify the size of the rendering window
	glViewport(0, 0, width, height);

	/*
	For example, a processed point of location (-0.5,0.5) 
	would be mapped to (200,450) 
	in screen coordinates if our window is (800, 600). 
	Note that processed coordinates in OpenGL are between -1 and 1,
	so we effectively map from the range (-1 to 1) to (0, 800) and (0, 600).
	Where will (0.25, -0.5) be mapped? 
	*/

	// Dark blue background
	glClearColor(0.0f, 0.0f, 0.4f, 0.0f);
	float i = 0.0f;
	float j = 0.0f;

	// Check if the window was closed
	while (!glfwWindowShouldClose(window))
	{
		// Check for events
		glfwPollEvents();

		// Swap buffers
		glfwSwapBuffers(window);

		if (i > 1.0f)
		{
			i = 0.0f;
		}

		if (j > 1.0f)
		{
			j = 0.0f;
		}

		glClearColor(i += 0.1f, 0.0f, j += 0.05f , 0.0f);


		// Clear the screen
		glClear(GL_COLOR_BUFFER_BIT);
	} 

	// Close OpenGL window and terminate GLFW
	glfwTerminate();

	return 0;
}


