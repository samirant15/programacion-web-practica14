.PHONY: default test help

default: help

# COLORS
GREEN  := $(shell tput -Txterm setaf 2)
YELLOW := $(shell tput -Txterm setaf 3)
WHITE  := $(shell tput -Txterm setaf 7)
RESET  := $(shell tput -Txterm sgr0)


TARGET_MAX_CHAR_NUM=20
# Show this help.
help:
	@echo ''
	@echo 'Usage:'
	@echo '  ${YELLOW}make${RESET} ${GREEN}<target>${RESET}'
	@echo ''
	@echo 'Targets:'
	@awk '/^[a-zA-Z\-\_0-9]+:/ { \
		helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")-1); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "  ${YELLOW}%-$(TARGET_MAX_CHAR_NUM)s${RESET} ${GREEN}%s${RESET}\n", helpCommand, helpMessage; \
		} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST)

## Build Project -> [docker(mvn clean install)]
install:
	@echo 'gradle build'
	@docker run --rm -u $(shell id -u):$(shell id -g) -v $(shell pwd):/home/gradle/project -w /home/gradle/project gradle gradle build -x test 

# build
image: install
	@echo 'docker build image'
	@docker build -t docker.juandiii.com/app .

## push
push:
	@echo 'push docker image'
	@docker push docker.juandiii.com/app:latest


## pull
pull:
	@echo 'pull docker image'
	@docker pull docker.juandiii.com/app:latest
