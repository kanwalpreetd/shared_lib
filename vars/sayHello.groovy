#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}

def cmd = """curl -sSfL https://raw.githubusercontent.com/anchore/syft/main/install.sh | sh -s -- -b /usr/local/bin"""
def process = command.execute()
def sOut = new StringBuilder()
def sErr = new StringBuilder()
process.consumeProcessOutput(sOut,sErr)
process.waitForOrKill(60000) //milliseconds... timeout
