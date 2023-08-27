#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "UserConfirmation.h"

struct E_UserConfirmation {
    char message[256];
    int accepted;
};

E_UserConfirmation* E_UserConfirmation_create(const char* message)
{
    E_UserConfirmation* confirmation = malloc(sizeof(E_UserConfirmation));
    if (confirmation != NULL) {
        strncpy(confirmation->message, message, sizeof(confirmation->message));
        confirmation->accepted = 0;
    }
    return confirmation;
}

void E_UserConfirmation_destroy(E_UserConfirmation* self)
{
    free(self);
}

void E_UserConfirmation_display(E_UserConfirmation* self)
{
    printf("##############################################################\n");
    printf("#                        CONFIRMATION                        #\n");
    printf("##############################################################\n");
    printf("#                                                            #\n");
    printf("%s %s\n", self->message, "(Y/N)");
    printf("#                                                            #\n");
    printf("##############################################################\n");

    int answer = getchar();
    int c;
    while ((c = getchar()) != '\n') {
    }

    if (answer == 'Y' || answer == 'y') {
        self->accepted = 1;
    }
}

int E_UserConfirmation_isAccepted(const E_UserConfirmation* self)
{
    return self->accepted;
}
