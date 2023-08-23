#include <stdlib.h> /* alloc */
#include <string.h> /* dup */

#include "product.h"

struct E_Product {
    char* name;
};

const E_Product* E_Product_create(const char* name)
{
    E_Product* product = malloc(sizeof(E_Product));
    if (product != NULL) {
        product->name = strdup(name);
    }
    return product;
}

void E_Product_destroy(const E_Product* self)
{
    free(self->name);
    free((void*)self);
}

const char* E_Product_name(const E_Product* self)
{
    return self->name;
}
