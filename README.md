# Web Test Automation Pipeline

This repository contains a web test automation pipeline that runs tests and generates a report using GitHub Actions.

## Features

- Automated web testing
- Continuous Integration with GitHub Actions
- Test report generation

## GitHub Actions Workflow

The GitHub Actions workflow is defined in `.github/workflows/test.yml`.

### Workflow Steps

1. **Trigger Events:**
   - On push to `main` branch
   - On pull request to `main` branch
   - Manually triggered with `workflow_dispatch`

2. **Job: start-test**
   - **Runs on:** `ubuntu-latest`

3. **Steps:**
   - **Checkout repository:** Uses the `actions/checkout@v4` action to check out the repository.
   - **Set up JDK 22:** Uses the `actions/setup-java@v4` action to set up Java Development Kit version 22.
   - **Install Chrome dependencies:** Installs necessary dependencies for running Chrome, including `wget`, `unzip`, and `google-chrome-stable`.
   - **Start Xvfb:** Starts the X virtual framebuffer (Xvfb) to run tests in a headless environment.
   - **Build with Maven:** Runs `mvn clean` to clean the project and install dependencies.
   - **Run tests:** Executes the tests using Maven with the specified browser name (default is `CHROME`).
   - **Get Allure history:** Checks out the `gh-pages` branch to retrieve the Allure report history.
   - **Allure report action:** Generates the Allure report and updates the history.
   - **Deploy report to GitHub Pages:** Deploys the generated Allure report to the `gh-pages` branch using the `crazy-max/ghaction-github-pages@v4` action.

## Report

After the tests are run, a report is generated and uploaded as an artifact. You can download the report from the GitHub Actions workflow run page.
