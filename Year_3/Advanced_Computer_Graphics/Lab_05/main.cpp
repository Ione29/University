// Include standard headers
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

// Include GLEW
#include "dependente/glew/glew.h"

// Include GLFW
#include "dependente/glfw/glfw3.h"

// Include GLM
#include "dependente/glm/glm.hpp"
#include "dependente/glm/gtc/matrix_transform.hpp"
#include "dependente/glm/gtc/type_ptr.hpp"

#include "shader.hpp"

//variables
GLFWwindow* window;
const int width = 1024, height = 768;

// lighting
glm::vec3 lightPos(-3.0f, 0.0f, 3.0f);
glm::vec3 lightColor(1.0f);

void window_callback(GLFWwindow* window, int new_width, int new_height)
{
	glViewport(0, 0, new_width, new_height);
}


int main(void)
{
	// Initialise GLFW
	if (!glfwInit())
	{
		fprintf(stderr, "Failed to initialize GLFW\n");
		return -1;
	}

	// Open a window and create its OpenGL context
	window = glfwCreateWindow(width, height, "3D demo", NULL, NULL);
	if (window == NULL) {
		fprintf(stderr, "Failed to open GLFW window.");
		getchar();
		glfwTerminate();
		return -1;
	}

	glfwMakeContextCurrent(window);

	// Initialize GLEW
	glewExperimental = true; // Needed for core profile
	if (glewInit() != GLEW_OK) {
		fprintf(stderr, "Failed to initialize GLEW\n");
		getchar();
		glfwTerminate();
		return -1;
	}

	//specify the size of the rendering window
	glViewport(0, 0, width, height);

	// Dark blue background
	glClearColor(0.0f, 0.0f, 0.4f, 0.0f);
	glClear(GL_COLOR_BUFFER_BIT);

	// Create and compile our GLSL program from the shaders
	// More about this in the following labs
	GLuint programID = LoadShaders("SimpleVertexShader.vertexshader", "SimpleFragmentShader.fragmentshader");
	GLuint programID2 = LoadShaders("LightVertexShader.vertexshader", "LightFragmentShader.fragmentshader");


	float vertices[] = {
		// front
		0.0, 0.0,  0.05,
		0.05, 0.0,  0.05,
		0.0,  0.05,  0.05,
		0.05,  0.05,  0.05,
		// back
		0.0, 0.0, 0.0,
		0.05, 0.0, 0.0,
		0.0,  0.05, 0.0,
		0.05,  0.05, 0.0
	};


	unsigned int indices[] = {  // note that we start from 0!
		0, 1, 2,
		1, 3, 2,
		2, 3, 7,
		2, 7, 6, 
		1, 7, 3, 
		1, 5, 7, 
		6, 7, 4,
		7, 5, 4, 
		0, 4, 1,
		1, 4, 5,
		2, 6, 4,
		0, 2, 4

	};

	glm::vec3 positions[] = {
		glm::vec3(0.0f,  0.0f,  0.2f),
		glm::vec3(0.2f,  0.5f, 0.1f),
		glm::vec3(-0.15f, -0.22f, 0),
		glm::vec3(-0.38f, -0.2f, -0.7),
		glm::vec3(0.24f, -0.4f, 0.1),
		glm::vec3(-0.17f,  0.3f, 0.7),
		glm::vec3(0.23f, -0.2f, 0.1),
		glm::vec3(0.15f,  0.2f, 0),
		glm::vec3(0.7f,  0.7f, 0.9),
		glm::vec3(-0.13f,  0.9f, 0)
	};


	// A Vertex Array Object (VAO) is an object which contains one or more Vertex Buffer Objects and is designed to store 
	// the information for a complete rendered object.
	GLuint vbo, vao, ibo;
	glGenVertexArrays(1, &vao);
	glGenBuffers(1, &vbo);
	glGenBuffers(1, &ibo);

	glBindVertexArray(vao);

	glBindBuffer(GL_ARRAY_BUFFER, vbo);
	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

	glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW);

	//set attribute pointers
	glVertexAttribPointer(
		0,                  // attribute 0, must match the layout in the shader.
		3,                  // size of each attribute
		GL_FLOAT,           // type
		GL_FALSE,           // normalized?
		3 * sizeof(float),                  // stride
		(void*)0            // array buffer offset
	);
	glEnableVertexAttribArray(0);
	
	glfwSetFramebufferSizeCallback(window, window_callback);

	// Check if the window was closed
	while (!glfwWindowShouldClose(window))
	{
		// Swap buffers
		glfwSwapBuffers(window);

		// Check for events
		glfwPollEvents();

		// Clear the screen
		glClear(GL_COLOR_BUFFER_BIT);

		// Use our shader
		glUseProgram(programID);
		
		//add view and projection matrices
		glm::mat4 view = glm::lookAt(
			glm::vec3(0.0f, 30.0f, 100.0f),
			glm::vec3(0.0f, 0.0f, -1.0f),
			glm::vec3(0.0f, 1.0f, 0.0f)
		);

		glm::mat4 projection = glm::perspective(
			glm::radians(45.0f),
			static_cast<float>(width) / static_cast<float>(height), 0.1f, 10000.0f
		);

		for(int i = 0; i < 10; i++)
		{

			glm::mat4 model;
			model = glm::translate(model, positions[i]);
			
			if(i != 0)
				model = glm::rotate(model, (float)glfwGetTime() * 100, glm::vec3(0.0f, 1.0f, 0.0f));

			if(i != 4)
				model = glm::rotate(model, (float)glfwGetTime() * 100, glm::vec3(0.0f, 1.0f, 0.0f));

			if(i != 8)
				model = glm::rotate(model, (float)glfwGetTime() * 100, glm::vec3(0.0f, 1.0f, 0.0f));

			//calculate MVP matrix
			//MVP = proection * view * model

			glm::mat4 mvp = projection * view * model;			

			unsigned int transformLoc = glGetUniformLocation(programID, "transform");
			glUniformMatrix4fv(transformLoc, 1, GL_FALSE, glm::value_ptr(mvp));

			unsigned int transformLoc2 = glGetUniformLocation(programID, "color");
			glUniform4fv(transformLoc2, 1, glm::value_ptr(glm::vec4(1.0f, 0.0f, 1.0f, 1.0f)));

			//bind VAO
			glBindVertexArray(vao);

			glDrawElements(GL_TRIANGLES, 36, GL_UNSIGNED_INT, 0);
		}

		//draw light
		//call glUseProgram

		//model fo

		glUseProgram(programID2);
		glm::mat4 matrix2 = = glm::mat4(1.0f)

		matrix2 = glm::translate(matrix2, )


	}

	// Cleanup VBO
	glDeleteBuffers(1, &vbo);
	glDeleteVertexArrays(1, &vao);
	glDeleteProgram(programID);

	// Close OpenGL window and terminate GLFW
	glfwTerminate();

	return 0;
}


