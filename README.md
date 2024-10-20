# TemplateProject

### TODO:

Cant fetch warehouse activities

Add isCompleted to appointments 

Can create multiple PDT for the same Appointment (Possibly make appointment_id a PK)

Send back to the landside the result of the creation of the PDT, successful or not (Solved with unique constrain?)

### Questions:

Do I need separated UUID in the PDT class if it is always 1-to-1 relationship?

ConveyorPayloadDumpHandler, is it a good naming?

Requests REST conventions

Extra table warehouse_activity_windows_activities, how to remove?

What is there are two appointments for the same tuck (license plate) for the same hour slot? Which one to take?