# TemplateProject

### TODO:

Cant fetch warehouse activities

Add isCompleted to appointments 

Can create multiple PDT for the same Appointment (Possibly make appointment_id a PK)

Send back to the landside the result of the creation of the PDT, successful or not (Solved with unique constrain?)

### Questions:

Would it be better to pass appointment_id instead of license_plate when exiting the facility?

Ask about EntranceRequest, is it a good solution?

Do we need to send the copy of the PDT to the driver after he dumped the material 

Do I need separated UUID in the PDT class if it is always 1-to-1 relationship?

ConveyorPayloadDumpHandler, is it a good naming?

Requests REST conventions

Extra table warehouse_activity_windows_activities, how to remove?

What is there are two appointments for the same tuck (license plate) for the same hour slot? Which one to take?