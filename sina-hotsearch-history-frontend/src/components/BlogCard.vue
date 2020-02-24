<template>
    <v-card
            max-width="310px"
            min-width="200px"
            class="mx-auto"
            light
            elevation="12"
    >
        <v-list-item>
            <v-list-item-avatar color="grey"></v-list-item-avatar>
            <v-list-item-content>
                <v-list-item-title>Our Changing Planet</v-list-item-title>
                <v-list-item-subtitle>by Kurt Wagner</v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

        <v-img
                src="https://cdn.vuetifyjs.com/images/cards/mountain.jpg"
        ></v-img>

        <v-card-text>
            Visit ten places on our planet that are undergoing the biggest changes today.
        </v-card-text>

        <v-card-actions>
            <v-icon class="margin-n">mdi-share-circle</v-icon>100
            <v-icon class="margin-n">mdi-message</v-icon>100
            <v-icon class="margin-n">mdi-thumb-up</v-icon>100
            <v-spacer></v-spacer>
            <v-btn icon>
                <v-icon>mdi-send</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "BlogCard"
    }
</script>

<style scoped>
    .margin-n{
        margin: 10px 2px;
    }
</style>